;This file will be executed next to the application bundle image
;I.e. current directory will contain folder Projeto-Integracao-Frontend-1.0-SNAPSHOT with application files
[Setup]
AppId={{UPDATE-DETECTION}}
AppName=Projeto-Integracao-Frontend-1.0-SNAPSHOT
AppVersion=1.0
AppVerName=Projeto-Integracao-Frontend-1.0-SNAPSHOT 1.0
AppPublisher=Eletra Energy Solutions
AppComments=Projeto-Integracao-Frontend-1.0-SNAPSHOT
AppCopyright=Copyright (C) 2025
;AppPublisherURL=http://java.com/
;AppSupportURL=http://java.com/
;AppUpdatesURL=http://java.com/
DefaultDirName={localappdata}\Projeto-Integracao-Frontend-1.0-SNAPSHOT
DisableStartupPrompt=Yes
DisableDirPage=Yes
DisableProgramGroupPage=Yes
DisableReadyPage=Yes
DisableFinishedPage=Yes
DisableWelcomePage=Yes
DefaultGroupName=Eletra Energy Solutions
;Optional License
LicenseFile=
;WinXP or above
MinVersion=0,5.1 
OutputBaseFilename=Projeto-Integracao-Frontend-1.0-SNAPSHOT-1.0
Compression=lzma
SolidCompression=yes
PrivilegesRequired=lowest
SetupIconFile=Projeto-Integracao-Frontend-1.0-SNAPSHOT\Projeto-Integracao-Frontend-1.0-SNAPSHOT.ico
UninstallDisplayIcon={app}\Projeto-Integracao-Frontend-1.0-SNAPSHOT.ico
UninstallDisplayName=Projeto-Integracao-Frontend-1.0-SNAPSHOT
WizardImageStretch=No
WizardSmallImageFile=Projeto-Integracao-Frontend-1.0-SNAPSHOT-setup-icon.bmp   
ArchitecturesInstallIn64BitMode=


[Languages]
Name: "brazilianportuguese"; MessagesFile: "compiler:Languages\BrazilianPortuguese.isl"

[Files]
Source: "Projeto-Integracao-Frontend-1.0-SNAPSHOT\Projeto-Integracao-Frontend-1.0-SNAPSHOT.exe"; DestDir: "{app}"; Flags: ignoreversion
Source: "Projeto-Integracao-Frontend-1.0-SNAPSHOT\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs

[Icons]
Name: "{group}\Projeto-Integracao-Frontend-1.0-SNAPSHOT"; Filename: "{app}\Projeto-Integracao-Frontend-1.0-SNAPSHOT.exe"; IconFilename: "{app}\Projeto-Integracao-Frontend-1.0-SNAPSHOT.ico";
Name: "{commondesktop}\Projeto-Integracao-Frontend-1.0-SNAPSHOT"; Filename: "{app}\Projeto-Integracao-Frontend-1.0-SNAPSHOT.exe";  IconFilename: "{app}\Projeto-Integracao-Frontend-1.0-SNAPSHOT.ico";


[Run]
Filename: "{app}\Projeto-Integracao-Frontend-1.0-SNAPSHOT.exe"; Parameters: "-install -svcName ""Projeto-Integracao-Frontend-1.0-SNAPSHOT"" -svcDesc ""Projeto-Integracao-Frontend-1.0-SNAPSHOT"" -mainExe ""Projeto-Integracao-Frontend-1.0-SNAPSHOT.exe""  ";