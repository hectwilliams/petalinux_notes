#
# This file is the clientapp recipe.
#

SUMMARY = "Simple clientapp application"
SECTION = "PETALINUX/apps"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = "\
		file://awesome.h 	\
		file://clientapp.c 	\
	"

S = "${WORKDIR}"

DEPENDS += "awesome"

# This uses libawesome

do_compile() {
	${CC} ${CFLAGS} ${LDFLAGS} -o clientapp clientapp.c -lawesome 
}

do_install() {
	     install -d ${D}${bindir}
	     install -m 0755 clientapp ${D}${bindir}
}

FILES:${PN} += "clientapp" 
