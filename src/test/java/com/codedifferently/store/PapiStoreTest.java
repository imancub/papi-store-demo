// This is the package it defines the family relation of objects
package com.codedifferently.store;

// This is importing the Assert, Before & Test Classes from the org.junit package/folder
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

// This is a public class called PapiStoreTest which will hold the scope of this class
    public class PapiStoreTest {
        // declaring a reference papiStore of type PapiStore
        PapiStore papiStore;
        // this is a fixture called Before which is used when we want to execute some codes before running the test.
        @Before
        // method called setup that returns nothing/void.  initializes a variation of the reference papiStore.
        public void setup(){
            papiStore = new PapiStore();
            papiStore.createActiveTab("Jamal");
            papiStore.createActiveTab("Victor");
            papiStore.owesPapiMoney.put("Jamal", 0.0);
            papiStore.owesPapiMoney.put("Victor", 7.0);
        }
        // test if store is open
        @Test
        public void OpenStoreTest(){
            //Given

            papiStore.openStore();

            //When
            Boolean expected = true;
            Boolean actual = papiStore.isStoreOpen();

            //Then
            //Assert.assertEquals(expected, actual);
            Assert.assertTrue(actual);
        }
        // success test for allowToUseTab
        @Test
        public void allowToUseTabTestSuccess(){
            // given
            PapiStore papiStore = new PapiStore();

            // when
            Boolean expected = true;
            Boolean actual = papiStore.allowToUseTab("Jamal");

            // then
            Assert.assertEquals(expected, actual);
        }
        // failure test for allowToUseTab
        @Test
        public void allowToUseTabTestFail(){
            // given
            PapiStore papiStore = new PapiStore();

            // when
            Boolean expected = false;
            Boolean actual = papiStore.allowToUseTab("Victor");

            // then
            Assert.assertEquals(expected, actual);
        }
}
