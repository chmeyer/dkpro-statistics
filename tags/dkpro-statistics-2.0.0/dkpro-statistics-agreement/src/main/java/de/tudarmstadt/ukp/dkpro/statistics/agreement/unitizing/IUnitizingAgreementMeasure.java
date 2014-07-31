/*******************************************************************************
 * Copyright 2014
 * Ubiquitous Knowledge Processing (UKP) Lab
 * Technische Universität Darmstadt
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package de.tudarmstadt.ukp.dkpro.statistics.agreement.unitizing;

import de.tudarmstadt.ukp.dkpro.statistics.agreement.IAgreementMeasure;

/**
 * Super interface for all {@link IAgreementMeasure}s for unitizing tasks.
 * That is, a measure of inter-rater agreement for 
 * {@link IUnitizingAnnotationStudy}s.
 * @see IAgreementMeasure
 * @see IUnitizingAnnotationStudy
 * @author Christian M. Meyer
 */
public interface IUnitizingAgreementMeasure extends IAgreementMeasure {
	
}
