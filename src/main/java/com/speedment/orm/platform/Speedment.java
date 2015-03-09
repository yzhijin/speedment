/**
 *
 * Copyright (c) 2006-2015, Speedment, Inc. All Rights Reserved.
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
package com.speedment.orm.platform;

import com.speedment.orm.annotations.Api;
import com.speedment.orm.config.model.Project;
import com.speedment.orm.core.manager.Manager;
import java.nio.file.Path;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

/**
 *
 * @author Emil Forslund
 */
@Api(version = 0)
public interface Speedment {

    boolean isRunning();

    Optional<Project> getProject();

    Optional<Path> getConfigPath();

    <T extends Component> T get(Class<T> clazz);

    public Stream<Map.Entry<Class<?>, Component>> components();
    
    <T> Manager<T> managerOf(Class<T> managedClass); 
    
    <T> Manager<T> customManager(Class<Manager<T>> managedClass); 
    
}