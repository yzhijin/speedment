/**
 *
 * Copyright (c) 2006-2016, Speedment, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); You may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.speedment.codegen.model;

import com.speedment.annotation.Api;
import com.speedment.codegen.model.modifier.FieldModifier;
import com.speedment.codegen.model.trait.HasAnnotationUsage;
import com.speedment.codegen.model.trait.HasCall;
import com.speedment.codegen.model.trait.HasCopy;
import com.speedment.codegen.model.trait.HasJavadoc;
import com.speedment.codegen.model.trait.HasName;
import com.speedment.codegen.model.trait.HasType;
import com.speedment.codegen.model.trait.HasValue;
import com.speedment.internal.codegen.model.FieldImpl;
import static java.util.Objects.requireNonNull;
import java.util.function.BiFunction;
import static java.util.Objects.requireNonNull;

/**
 * A model that represents a field in code. This can be either as a method
 * parameter or as a class member.
 *
 * @author Emil Forslund
 * @since  2.0
 */
@Api(version = "2.3")
public interface Field extends HasCopy<Field>, HasCall<Field>, HasName<Field>,
    HasType<Field>, HasJavadoc<Field>, HasValue<Field>, HasAnnotationUsage<Field>,
    FieldModifier<Field> {

    /**
     * Factory holder.
     */
    enum Factory {
        INST;
        private BiFunction<String, Type, Field> mapper = FieldImpl::new;
    }

    /**
     * Creates a new instance implementing this interface by using the class
     * supplied by the default factory. To change implementation, please use the
     * {@link #setMapper(java.util.function.BiFunction) setSupplier} method.
     *
     * @param name the name
     * @param type the type
     * @return the new instance
     */
    static Field of(String name, Type type) {
        return Factory.INST.mapper.apply(name, type);
    }

    /**
     * Sets the instantiation method used to create new instances of this
     * interface.
     *
     * @param mapper the new constructor
     */
    static void setMapper(BiFunction<String, Type, Field> mapper) {
        Factory.INST.mapper = requireNonNull(mapper);
    }
}
