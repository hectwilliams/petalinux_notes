#
# This file is the awesome recipe.
#

SUMMARY = "awesome library"
SECTION = "libs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = " \
		file://awesome.c 	\
		file://awesome.h 	\
	   	file://Makefile		\
	"

S = "${WORKDIR}"

PACKAGE_ARCH = "${MACHINE_ARCH}"
PROVIDES = "awesome"
TARGET_CC_ARCH += "${LDFLAGS}"

do_compile() {
	     oe_runmake
}

do_install() {

	install -d ${D}${libdir}
	oe_libinstall -so libawesome ${D}${libdir}


}

FILES:${PN}="${libdir}/*.so.* ${includedir}/*"
FILES:${PN}-dev="${libdir}/*.so"
