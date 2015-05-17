SUMMARY = "Kernel Module for mpex driver"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://readme;md5=e350d505ad1f18de366f3624c29abd63"

inherit module

PR = "r0"
PV = "0.1"

SRC_URI = "file://99xx.c \
	   file://99xx.h \
	   file://gpio.c \
	   file://ioctl.c \
	   file://ioctl.h \
	   file://Makefile \
	   file://mcs99xx \
	   file://readme \
"

S = "${WORKDIR}"

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.
