tests
=====

Tests with several technologies

# Per fare girare tutto sotto Karaf

- Installo karaf pulito
- lancio
- faccio (per web console)
	- feature:install webconsole
- faccio (declarative services
	- feature:install scr
- cambio il log in org.ops4j.pax.logging.cfg
	- aggiungo stdout ai log printati
		- log4j.rootLogger=INFO, out, stdout, osgi:*
	- modifico l'appender stdout per avere la treshold a TRACE
		- log4j.appender.org.energy_home=TRACE
			
- butto i miei bundle in deploy


# note
- http://sully6768.blogspot.it/2012/09/scr-components-with-karaf.html


 # Per flashare il CC2530 da linux
 
 http://sourceforge.net/projects/cctool/
	more specifically http://sourceforge.net/projects/cctool/files/cc-tool-0.26-src.tgz/download
		(serve installare libboost-all-dev libusb-1.0-0-dev)
		./configure
		make
		make install
		
Smadonno un po' con gli spinotti finche il flasher non diventa verde

bluewind@domus:~/tmp$ sudo cc-tool
  Programmer: CC Debugger
  Target: CC2531
  No actions specified

Faccio il backup		
	sudo cc-tool -r image-predefined-cc2531-20150107.hex
		
poi scarico lo sniffer da qui: http://zboss.dsr-wireless.com/projects/zboss/wiki/ZBOSS_Sniffer#For-Developers

Flashio /opt/ZBOSS_Sniffer_v1.0_x86_Linux_bin/hex/CC2531-USB-Dongle-Release/Exe
sudo cc-tool -v -e -w zboss_sniffer.hex 

stacco il programmer

la chiavetta viene riconosciuta come ACM

LANCIO !!!
LD_LIBRARY_PATH=$LD_LIBRARY_PATH:./ ./zboss_sniffer

# chiavi di crittografia ?
https://github.com/ismb/jemma/blob/acbf63716522adbb1329942394df56dd1575f3b6/jemma.osgi.javagal/src/main/resources/config.properties
https://www.wireshark.org/lists/wireshark-users/201103/msg00046.html


Da provare anche	
 
http://www.perytons.com/zigbee/download
http://docs.ubilogix.com/ubiqua/supported-hardware/
