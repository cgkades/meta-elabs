#KDIR:=/lib/modules/$(shell  uname -r)/build/ 

DEBIAN_VERSION_FILE:=/etc/debian_version
DEBIAN_DISTRO:=$(wildcard $(DEBIAN_VERSION_FILE))
CURRENT=$(shell uname -r)
MAJORVERSION=$(shell uname -r | cut -d '.' -f 1)
MINORVERSION=$(shell uname -r | cut -d '.' -f 2)
SUBLEVEL=$(shell uname -r | cut -d '.' -f 3)

ifeq ($(MAJORVERSION),3)
MDIR=drivers/tty/serial
else
ifeq ($(MAJORVERSION),2)
ifneq (,$(filter $(SUBLEVEL),38 39))
MDIR=drivers/tty/serial
else
MDIR=drivers/serial
endif
else
MDIR=drivers/serial
endif
endif

obj-m +=99xx.o

default:
	$(RM) *.mod.c *.o *.ko .*.cmd *.symvers
	$(MAKE) -C $(KERNEL_SRC) SUBDIRS=$(PWD) modules
	gcc -pthread ioctl.c -o ioctl
	gcc -pthread gpio.c -o gpio

install:
	cp 99xx.ko  /lib/modules/$(shell uname -r)/kernel/$(MDIR)
	depmod -A
	chmod +x mcs99xx
	cp mcs99xx /etc/init.d/
ifeq ($(DEBIAN_DISTRO), $(DEBIAN_VERSION_FILE))
	ln -s /etc/init.d/mcs99xx /etc/rcS.d/Smcs99xx || true
else
	ln -s /etc/init.d/mcs99xx /etc/rc.d/rc3.d/Smcs99xx || true  	
	ln -s /etc/init.d/mcs99xx /etc/rc.d/rc5.d/Smcs99xx || true
endif
	modprobe 99xx

modules_install:
	$(MAKE) -C $(KERNEL_SRC) M=$(SRC) modules_install

	
uninstall:
	modprobe -r 99xx
	rm -f /lib/modules/$(shell uname -r)/kernel/$(MDIR)/99xx.*
	depmod -A
	rm -f /etc/init.d/mcs99xx
ifeq ($(DEBIAN_DISTRO), $(DEBIAN_VERSION_FILE))
	rm -f /etc/init.d/mcs99xx /etc/rcS.d/Smcs99xx || true
else
	rm -f /etc/rc.d/rc3.d/Smcs99xx
	rm -f /etc/rc.d/rc5.d/Smcs99xx
endif

clean:
	$(RM) *.mod.c *.o *.ko .*.cmd *.symvers *~
	rm -rf .tmp_version*
	rm -rf Module.markers modules.*
	rm -f ioctl gpio
