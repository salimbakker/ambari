/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.ambari.common.rest.entities;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BlueprintType complex type.
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Blueprint", propOrder = {
    "repositories",
    "configuration",
    "components"
})
@XmlRootElement
public class Blueprint {

    @XmlAttribute
    protected String name;
    @XmlAttribute
    protected String revision;
    @XmlAttribute
    protected String parentName;
    @XmlAttribute
    protected String parentRevision;

    @XmlElement
    protected List<RepositoryKind> repositories;
    
    @XmlElement
    protected Configuration configuration;
    
    @XmlElement
    protected List<Component> components;
    
    /**
     * @return the name
     */
    public String getName() {
            return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
            this.name = name;
    }
    /**
     * @return the revision
     */
    public String getRevision() {
            return revision;
    }
    /**
     * @param revision the revision to set
     */
    public void setRevision(String revision) {
            this.revision = revision;
    }
    
    /**
     * @return the parentName
     */
    public String getParentName() {
            return parentName;
    }
    /**
     * @param parentName the parentName to set
     */
    public void setParentName(String parentName) {
            this.parentName = parentName;
    }
    /**
     * @return the parentRevision
     */
    public String getParentRevision() {
            return parentRevision;
    }
    /**
     * @param parentRevision the parentRevision to set
     */
    public void setParentRevision(String parentRevision) {
            this.parentRevision = parentRevision;
    }
    /**
     * @return the packageRepositories
     */
    public List<RepositoryKind> getPackageRepositories() {
            return repositories;
    }
    /**
     * @param packageRepositories the packageRepositories to set
     */
    public void setPackageRepositories(
                    List<RepositoryKind> value) {
            this.repositories = value;
    }
    /**
     * @return the configuration
     */
    public Configuration getConfiguration() {
            return configuration;
    }
    /**
     * @param configuration the configuration to set
     */
    public void setConfiguration(Configuration configuration) {
            this.configuration = configuration;
    }
    /**
     * @return the components
     */
    public List<Component> getComponents() {
            return components;
    }
    /**
     * @param components the components to set
     */
    public void setComponents(List<Component> components) {
            this.components = components;
    }

}
