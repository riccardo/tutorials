# Tests with Luxoft BitCatcher Sniffer

The sniffer can be downloaded from the [Luxoft website](http://www.luxoft.com/embedded-systems-development/bitcatcher/), direct link [here](http://offer.luxoft.com/content-request.html?FILE_ID=37912) (requires registration).

Backup download on my dropbox:

https://www.dropbox.com/s/iyvefvscy9hg4rb/Sniffer_1.0.1_public.zip?dl=0

It works with Atmel [RZUSBStick](http://store.atmel.com/PartDetail.aspx?q=p:10500060#tc:description) available from [Farnell](http://it.farnell.com/atmel/atavrzusbstick/at86rf230-usb-stick-starter-kit/dp/1562234) currently for about 37 EUR.

Tested with version 1.0.1 (file name ``Sniffer_1.0.1_public.zip``).

## Launching the Sniffer

After connecting the RZUSBStick on my Linux, ``dmesg`` returns:


```````
[ 6191.429120] usb 2-1.2.1.4: new full-speed USB device number 8 using ehci-pci
[ 6191.524162] usb 2-1.2.1.4: New USB device found, idVendor=03eb, idProduct=210a
[ 6191.524175] usb 2-1.2.1.4: New USB device strings: Mfr=1, Product=2, SerialNumber=3
[ 6191.524181] usb 2-1.2.1.4: Product: RZUSBSTICK
[ 6191.524186] usb 2-1.2.1.4: Manufacturer: ATMEL
[ 6191.524190] usb 2-1.2.1.4: SerialNumber: 00DEADBEEF00
```````

After unzipping the sniffer, you can install with:

```java -jar BitCatcher_Setup_1.0.0.jar```

In my case I installed under ```/opt/Luxoft/BitCatcher```

You can then launch with ```/opt/Luxoft/BitCatcher/sniffer```

In my set-up the sniffer did not recognize the RZUSBStick at first.

from [this page](https://www.assembla.com/spaces/EmsProjectBuildingAutomation/wiki/Tutorial_installing_Contiki_on_Raven_) I found a way to install firmware on the rzusb ...

avrdude -p ATmega1284P -c jtag2 -P usb -U flash:w:webserver6-avr-raven.hex 

Tools downloaded from [there](http://www.atmel.com/tools/RZUSBSTICK.aspx)

To Re-program the RZUSBSTICK you need a JTAG programmer:  

http://it.farnell.com/atmel/atjtagice3/debugger-jtag-spi-pdi-for-avr/dp/1972230


# Zboss sniffer

CC2531 USB evaluation kit.

The ZBoss Sniffer can be downloaded from [here](http://zboss.dsr-wireless.com/downloads/index/zboss)

Backup donwload on my dropbox:

https://www.dropbox.com/s/qedvhu17umtg932/ZBOSS_Sniffer_v1.0_x86_Linux_bin.tar.gz?dl=0

To launch:

export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:/home/bluewind/OfflineWorkspaces/worl_20141230_zigbee_and_tutorials/ZBOSS_Sniffer_v1.0_x86_Linux_bin/gui

To make it appear on linux:

http://e2e.ti.com/support/wireless_connectivity/f/158/t/150382

# Sniffing with MC1322xusb dongle

Check out this project: http://sourceforge.net/projects/wiresharkzigbee

Downloading 0.4 from here: http://sourceforge.net/projects/wiresharkzigbee/files/alpha/src_0.4/

(saved off-line as MC1322x_Wireshark_Linux_v0_4.tar.bz2)


## To launch

python WS_ZigbeeSnifferPipeWrapper.py --port=/dev/ttyUSB0 --channel=14

(channels 11 -> 26)

wireshark 

-> Capture on pipe.

I found a network on channel 11.

To decrypt https://www.wireshark.org/lists/wireshark-users/201103/msg00046.html




Il roomba usa Zigbee ? http://www.robotreviews.com/chat/viewtopic.php?t=7529&start=20
Ci si può fare wardriving ? https://www.kismetwireless.net/kisbee/


Idea per debuggare : https://www.anaren.com/air-wiki-zigbee/Troubleshooting_Zigbee_Communications

Anche interessante guardarsi i testers: https://www.anaren.com/air-wiki-zigbee
