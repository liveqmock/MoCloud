@CLS

@SET HOME=E:\Microbject
@SET SOURCE=%HOME%\MoCloud
@SET TARGET=%HOME%\AliSvn-Microbject

xcopy /E /I /Y %SOURCE%\mp-cloud-content\webroot %TARGET%\cloud.content\webroot

xcopy /E /I /Y %HOME%\MoScript\source\home        %TARGET%\webroot
xcopy /E /I /Y %HOME%\MoScript\source\ajs\release %TARGET%\webroot\engine\ajs
xcopy /E /I /Y %HOME%\MoScript\source\ar3\shader  %TARGET%\webroot\engine\ar3\shader
xcopy /E /I /Y %HOME%\MoScript\source\ars         %TARGET%\webroot\engine\ars
