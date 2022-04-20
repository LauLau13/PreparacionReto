param([switch]$Elevated)

function Test-Admin {
    $currentUser = New-Object Security.Principal.WindowsPrincipal $([Security.Principal.WindowsIdentity]::GetCurrent())
    $currentUser.IsInRole([Security.Principal.WindowsBuiltinRole]::Administrator)
}

if ((Test-Admin) -eq $false)  {
    if ($elevated) {
    } else {
        Start-Process powershell.exe -Verb RunAs -ArgumentList ('-noprofile -noexit -file "{0}" -elevated' -f ($myinvocation.MyCommand.Definition))
    }
    exit
}
Set-Location -LiteralPath $PSScriptRoot
(Get-Content C:\oraclexe\app\oracle\product\11.2.0\server\network\ADMIN\listener.ora) -replace 'A8-PC00', '127.0.0.1' | Out-File -encoding ASCII C:\oraclexe\app\oracle\product\11.2.0\server\network\ADMIN\listener.ora
net start OracleXETNSListener
sqlplus / as sysdba '@listenerfix.sql'