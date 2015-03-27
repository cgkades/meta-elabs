SUMMARY = "gphoto2 allows you to access digital cameras"
SECTION = "libs"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

PR = "r5"

DEPENDS = "libtool jpeg virtual/libusb0 libexif libgphoto2 popt"

SRC_URI = "file://gphoto2-${PV}.tar.bz2;name=gphoto2 \
"
inherit gettext

SRC_URI[libgphoto2.md5sum] = "2635075f702b40eb2e95a80658bd4773"
#SRC_URI[libgphoto2.sha256sum] = "5116bbacea57dfe22585e8e939ea30b5fb99fe08de526002788c84e37105c423"

#EXTRA_OEMAKE = "'CC=${CC}' 'RANLIB=${RANLIB}' 'AR=${AR}' 'CFLAGS=${CFLAGS} -I${S}/include -DWITHOUT_XATTR' 'BUILDDIR=${S}'"
EXTRA_OEMAKE = "'CC=${CC}'"

#EXTRA_OECONF = " --with-drivers=all udevscriptdir=/lib/udev ac_cv_lib_ltdl_lt_dlcaller_register=yes"

do_configure() {
	./configure --host=x86_64 i586
}

do_install() {
    #oe_runmake install DESTDIR=${D} SBINDIR=${sbindir} MANDIR=${mandir} INCLUDEDIR=${includedir}
    oe_runmake install DESTDIR=${D} 
}

