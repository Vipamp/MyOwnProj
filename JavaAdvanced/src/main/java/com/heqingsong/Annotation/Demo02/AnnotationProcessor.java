/**
 * File: AnnotationProcessor.java 　　2018/11/12 23:11
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * 自定义注解处理器
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Annotation.Demo02;

import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.element.TypeElement;
import java.util.Set;

@SupportedAnnotationTypes({"com.heqingsong.Annotation.Demo02.FiledDef"})
@AutoService(Processor.class)
public class AnnotationProcessor extends AbstractProcessor {

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("into AnnotationProcessor success!");
        return false;
    }

}
