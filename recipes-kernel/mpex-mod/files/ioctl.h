/* Definition for IOCTL */
#define IOCTL_SET_CUSTOM		_IOW(0xD0, 11, int)
#define IOCTL_GET_CUSTOM		_IOR(0xD0, 12, int)

#define IOCTL_GPIO_DIR		_IOW(0xD0, 13, int)
#define IOCTL_GPIO_STATUS	_IOW(0xD0, 14, int)
#define IOCTL_GPIO_OUTPUT	_IOR(0xD0, 15, int)

#define IOCTL
