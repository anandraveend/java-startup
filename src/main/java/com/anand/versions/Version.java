package com.anand.versions;

public @interface Version {
	int major();
	int minor() default 0;
}
