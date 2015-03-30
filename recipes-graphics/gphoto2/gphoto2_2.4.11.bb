SUMMARY = "gphoto2 allows you to access digital cameras"
SECTION = "libs"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

PR = "r5"

DEPENDS = "libtool jpeg virtual/libusb0 libexif libgphoto2 popt"
SRC_URI = "${SOURCEFORGE_MIRROR}/gphoto/gphoto2-${PV}.tar.gz;name=gphoto2"
#SRC_URI = "file://gphoto2-${PV}.tar.bz2;name=gphoto2"

inherit gettext autotools pkgconfig lib_package

SRC_URI[gphoto2.md5sum] = "785a5ae1004013a38bcb7e2663a3eda3"
SRC_URI[gphoto2.sha256sum] = "86d0bdba3972f52e52905938e7f674d678e4ddd83454abc12851e8155097ba44"

#EXTRA_OEMAKE = "'CC=${CC}' 'RANLIB=${RANLIB}' 'AR=${AR}' 'CFLAGS=${CFLAGS} -I${S}/include -DWITHOUT_XATTR' 'BUILDDIR=${S}'"
#EXTRA_OEMAKE = "'CC=${CC}'"

#EXTRA_OECONF = " --with-drivers=all udevscriptdir=/lib/udev ac_cv_lib_ltdl_lt_dlcaller_register=yes"

#do_install () {
#           autotools_do_install
##           install -d ${D}${base_bindir}
##           mv ${D}${bindir}/gphoto2 ${D}${base_bindir}/gphoto2
##           rmdir ${D}${bindir}/
#}
