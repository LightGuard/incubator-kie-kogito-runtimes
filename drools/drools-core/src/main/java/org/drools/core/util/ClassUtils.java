/*
 * Copyright 2010 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.core.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.drools.core.common.DroolsObjectInputStream;
import org.drools.core.common.DroolsObjectOutputStream;

public abstract class ClassUtils extends org.drools.reflective.util.ClassUtils {

    protected ClassUtils() { }

    public static <T extends Externalizable> T deepClone(T origin) {
        return origin == null ? null : deepClone(origin, origin.getClass().getClassLoader());
    }
    
    public static <T extends Externalizable> T deepClone(T origin, ClassLoader classLoader) {
        return deepClone(origin, classLoader, Collections.emptyMap());
    }

    public static <T extends Externalizable> T deepClone(T origin, ClassLoader classLoader, Map<String, Object> cloningResources) {
        if (origin == null) {
            return null;
        }
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DroolsObjectOutputStream oos = new DroolsObjectOutputStream(baos);
            if ( cloningResources != null ) { cloningResources.forEach( (k, v) -> oos.addCustomExtensions(k, v) ); }
            oos.writeObject(origin);
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            DroolsObjectInputStream ois = new DroolsObjectInputStream(bais, classLoader);
            if ( cloningResources != null ) { cloningResources.forEach( (k, v) -> ois.addCustomExtensions(k, v) ); }
            Object deepCopy = ois.readObject();
            return (T)deepCopy;
        } catch(IOException ioe) {
            throw new RuntimeException(ioe);
        } catch (ClassNotFoundException cnfe) {
            throw new RuntimeException(cnfe);
        }
    }
}
