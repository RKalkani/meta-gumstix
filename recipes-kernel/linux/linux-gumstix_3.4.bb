require recipes-kernel/linux/linux-yocto.inc

# This kernel matches the hardware acceleration binaries provided for OMAP4
# in the ubuntu releases. If you need hardware acceleration for DuoVero, start
# here!

KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "duovero"

LINUX_VERSION = "3.4"
LINUX_VERSION_EXTENSION = "-custom"

BOOT_SPLASH ?= "logo_linux_clut224-generic.ppm"

# Patches for all releases in linux-3.5.y but PV specifies upstream base.
# Patches at: git://github.com/gumstix/linux.git;branch=omap-3.5
FILESEXTRAPATHS_prepend := "${THISDIR}/linux-gumstix-3.4:"

S = "${WORKDIR}/git"

# ti-ubuntu-3.4-1487.6 = c34a43ec74168b892a948b45695486f1a3d700af
SRCREV = "c34a43ec74168b892a948b45695486f1a3d700af"
SRC_URI = " \
    git://dev.omapzoom.org/pub/scm/integration/kernel-ubuntu.git;nocheckout=1;branch=ti-ubuntu-3.4-1487 \
    file://0001-arm-omap4-Add-DuoVero-machine.patch \
    file://defconfig \
    file://${BOOT_SPLASH} \
"
