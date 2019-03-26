/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

/*
 * Copyright 2014 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.09.23 at 11:05:22 PM CDT 
//
package org.drools.core.meta.org.test;

import java.util.ArrayList;
import java.util.List;

import org.drools.core.metadata.MetadataHolder;

public class AnotherKlassImpl implements AnotherKlass, MetadataHolder {

    protected int num;
    protected Klass theKlass;
    protected List<Klass> manyKlasses = new ArrayList<Klass>();
    protected List<Klass> manyMoreKlasses = new ArrayList<Klass>();

    public AnotherKlassImpl() {
        super();
    }

    public AnotherKlassImpl( final int num ) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum( int num ) {
        this.num = num;
    }

    @Override
    public Klass getTheKlass() {
        return theKlass;
    }

    @Override
    public void setTheKlass( Klass klass ) {
        this.theKlass = klass;
    }

    private final AnotherKlass_ _ = new AnotherKlass_( this );

    public AnotherKlass_ get_() {
        return _;
    }

    public List<Klass> getManyKlasses() {
        return manyKlasses;
    }

    public void setManyKlasses( List<Klass> manyKlasses ) {
        this.manyKlasses = manyKlasses;
    }

    public List<Klass> getManyMoreKlasses() {
        return manyMoreKlasses;
    }

    public void setManyMoreKlasses( List<Klass> manyMoreKlasses ) {
        this.manyMoreKlasses = manyMoreKlasses;
    }
}

