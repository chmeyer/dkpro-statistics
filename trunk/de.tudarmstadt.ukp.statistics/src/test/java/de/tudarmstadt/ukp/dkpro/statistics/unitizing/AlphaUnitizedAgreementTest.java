/*******************************************************************************
 * Copyright 2013
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
package de.tudarmstadt.ukp.dkpro.statistics.unitizing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Unit tests for {@link AlphaUnitizedAgreement} 
 */
public class AlphaUnitizedAgreementTest
{

    private AlphaUnitizedAgreement alphaForKrippendorfStudy;

    @Before
    public void setUp()
    {
        final UnitizingStudy study = StudyFactory.getKrippendorfSampleStudy();
        this.alphaForKrippendorfStudy = new AlphaUnitizedAgreement(study);
    }

    @Test
    public void testAlphaUnitizedAgreementObservedDisagreement()
    {
        assertEquals(0.0144, this.alphaForKrippendorfStudy.getObservedDisagreement("c"), 0.0001);
        assertEquals(0.0, this.alphaForKrippendorfStudy.getObservedDisagreement("k"), 0.0);
    }

    @Test
    public void testAlphaUnitizedAgreementExpectedDisagreement()
    {
        assertEquals(0.0532, this.alphaForKrippendorfStudy.getExpectedDisagreement("c"), 0.0001);
        assertEquals(0.0490, this.alphaForKrippendorfStudy.getExpectedDisagreement("k"), 0.0001);
    }

    @Test
    public void testAlphaUnitizedCategoryAgreement()
    {
        // The expected value differs from the value
        // of Krippendorf's paper because there
        // all values are rounded to 4 decimal places
        assertEquals(0.7285, this.alphaForKrippendorfStudy.estimateCategoryAgreement("c"), 0.0001);
        assertEquals(1.0, this.alphaForKrippendorfStudy.estimateCategoryAgreement("k"), 0.0001);
    }

    @Test
    public void testAlphaUnitizedJointAgreement()
    {
        // The expected value differs from the value
        // of Krippendorf's paper because there
        // all values are rounded to 4 decimal places
        assertEquals(0.8587, this.alphaForKrippendorfStudy.estimateJointAgreement(), 0.0001);

    }

    @Ignore
    @Test
    public void testOnlyOneAnnotation()
    {
        final UnitizingStudy study = new UnitizingStudy(3);
        study.addSection("X", 0, 1, 1);
        study.setContinuumLength(20);
        study.close();

        final AlphaUnitizedAgreement agreement = new AlphaUnitizedAgreement(study);

        assertTrue(agreement.estimateJointAgreement() < 1.0);
    }
}
