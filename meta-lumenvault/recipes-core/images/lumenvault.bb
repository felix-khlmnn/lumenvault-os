# Base the image on core-image-base
include recipes-core/images/core-image-base.bb

# Install base packagegroup
IMAGE_INSTALL:append = " packagegroup-lumenvault-base"

# Activate basic features
IMAGE_FEATURES:append = " ssh-server-openssh"
