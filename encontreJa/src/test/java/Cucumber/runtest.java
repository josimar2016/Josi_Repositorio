/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cucumber;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 *
 * @author arrais
 */

@RunWith(Cucumber.class)
@Cucumber.Options(
        format = {"/home/arrais/NetBeansProjects/TQS_G3_Repositorio/encontreJa/src/test/java/Cucumber/features/allFeatures.feature"},
        tags = "@login"
)
public class runtest {

}
