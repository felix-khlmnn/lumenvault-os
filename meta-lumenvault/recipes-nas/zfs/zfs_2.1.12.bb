SUMMARY = "ZFS 2.1.12"
LICENSE = "CDDL-1.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/CDDL-1.0;md5=d63dcc9297f2efd6c18d1e560b807bc6"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "https://github.com/openzfs/zfs/releases/download/zfs-2.1.12/zfs-2.1.12.tar.gz"
SRC_URI[sha256sum] = "64daa26aed3e12c931f6f4413d7527c4ebdb8da35416b356152b5f9fdd4c6e6d"
# Leave ${S} at its defualt value as it's fitting the build context

# List all dependencies
DEPENDS = "autoconf automake python3 python3-setuptools python3-cffi libffi python3-packaging git python3-sphinx"


do_configure() {
    sh ${S}/autogen.sh

    # Using --host to show that we're cross compiling for arm64
    ./${S}/configure --target="arm64" --host="x86_64"
}

do_compile() {
    oe_runmake -C ${S}
}

do_install() {
    install -d ${D}${sbindir}
    install -m 0755 ${S}/zfs ${D}${sbindir}
}
