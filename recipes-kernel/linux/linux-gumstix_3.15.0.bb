require recipes-kernel/linux/linux-yocto.inc

COMPATIBLE_MACHINE = "overo|pepper|duovero"

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"

KERNEL_DEVICETREE_overo = " \
    omap3-overo-storm-tobi.dtb omap3-overo-tobi.dtb \
    omap3-overo-storm-chestnut43.dtb omap3-overo-chestnut43.dtb \
    omap3-overo-storm-alto35.dtb omap3-overo-alto35.dtb \
    omap3-overo-storm-gallop43.dtb omap3-overo-gallop43.dtb \
    omap3-overo-storm-palo43.dtb omap3-overo-palo43.dtb \
    omap3-overo-storm-summit.dtb omap3-overo-summit.dtb \
"
KERNEL_DEVICETREE_duovero = "omap4-duovero-parlor.dtb"
KERNEL_DEVICETREE_pepper = "am335x-pepper.dtb"

LINUX_VERSION = "3.15.0"
LINUX_VERSION_EXTENSION = "-custom"

BOOT_SPLASH ?= "logo_linux_clut224-generic.ppm"

# Patches for all releases in linux-3.15.y but PV specifies upstream base.
# Patches at: git://github.com/gumstix/linux.git;branch=gumstix-3.15.0
FILESEXTRAPATHS_prepend := "${THISDIR}/linux-gumstix-3.15:"

S = "${WORKDIR}/git"

# v3.15-rc6 = 4b660a7f5c8099d88d1a43d8ae138965112592c7
SRCREV = "4b660a7f5c8099d88d1a43d8ae138965112592c7"

SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux-2.6.git;nocheckout=1;branch=master \
    file://0001-OMAPDSS-panel-dpi-Add-DT-support.patch \
    file://0002-panel-dpi-use-gpiod-for-enable-gpio.patch \
    file://0003-OMAPDSS-panel-lgphilips-lb035q02-Add-DT-support.patch \
    file://0004-OMAPDSS-panel-lgphilips-lb035q02-use-gpiod-for-enabl.patch \
    file://0005-OMAPDSS-move-compatible-converter-to-omapdss-driver.patch \
    file://0006-ARM-dts-overo-Add-support-for-DVI-output.patch \
    file://0007-ARM-dts-overo-Add-support-for-4.3-LCD-output.patch \
    file://0008-ARM-dts-overo-Add-support-for-3.5-LCD-output.patch \
    file://0009-Add-devicetree-for-Gumstix-Pepper-SBC.patch \
    file://0010-HACK-Invert-the-y-axis-of-the-touchscreen-for-pepper.patch \
    file://0011-OMAP-DSS-panel-dpi-and-enable-gpios.patch \
    file://0012-ARM-dts-Enable-mcpdm-and-mcbsp1-on-DuoVero.patch \
    file://0013-ARM-dts-duovero-parlor-Add-HDMI-output.patch \
    file://0014-reset-is_reset-and-clear_reset-api-s.patch \
    file://defconfig \
    file://${BOOT_SPLASH} \
"
