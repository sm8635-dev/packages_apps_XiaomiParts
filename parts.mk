#
# Copyright (C) 2024 The LineageOS Project
#
# SPDX-License-Identifier: Apache-2.0
#

# Parts
PARTS_PATH := packages/apps/XiaomiParts

# Properties
TARGET_VENDOR_PROP += $(PARTS_PATH)/common/defaults_common.prop

# Soong Namespace
PRODUCT_SOONG_NAMESPACES += \
   $(PARTS_PATH)

# Sepolicy
BOARD_VENDOR_SEPOLICY_DIRS += $(PARTS_PATH)/sepolicy/vendor
SYSTEM_EXT_PRIVATE_SEPOLICY_DIRS += $(PARTS_PATH)/sepolicy/private
SYSTEM_EXT_PUBLIC_SEPOLICY_DIRS += $(PARTS_PATH)/sepolicy/public

# XiaomiParts
PRODUCT_PACKAGES += \
    XiaomiParts
