require u-boot.inc

PV = "2014.07"

COMPATIBLE_MACHINE = "overo|duovero|pepper"

# v2014.07-rc2+
SRCREV = "3e1fa221f94b7ae3389d166882b77f1da5895f22"
SRC_URI = "git://git.denx.de/u-boot.git;branch=master;protocol=git \
    file://0001-omap4-duovero-Correct-name-of-default-device-tree.patch \
    file://0002-omap3-overo-Select-fdtfile-for-expansion-board.patch \
    file://0003-omap-Don-t-enable-GPMC-CS0-with-nothing-attached.patch \
"

SRC_URI_append_overo = "file://fw_env.config"

SPL_BINARY = "MLO"
