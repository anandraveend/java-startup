package com.anand.annotations;

public @interface Version {
	int major();
	int minor() default 0;
}
