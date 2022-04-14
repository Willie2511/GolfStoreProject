package com.golfstore.Arquillian;

import org.eu.ingwar.tools.arquillian.extension.suite.annotations.ArquillianSuiteDeployment;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;

@ArquillianSuiteDeployment
public class ArquillianDeployment {

    static WebArchive war;

    @org.jboss.arquillian.container.test.api.Deployment
    public static WebArchive createDeployment() {
        if(war != null) return war;
        war = ShrinkWrap.create(WebArchive.class)
                .addPackages(true, "com/golfstore")
                .addAsWebInfResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"))
                .addAsResource("META-INF/JTA-persistence.xml", "META-INF/persistence.xml")
                .addAsLibraries(
                        Maven.resolver()
                                .loadPomFromFile("pom.xml")
                                .resolve(
                                        "at.favre.lib:bcrypt:0.9.0", "mysql:mysql-connector-java:8.0.28"
                                        )
                                .withTransitivity().asFile());
        System.out.println(war.toString(true));
        return war;
    }

    @Test
    public void testDeployment(){
        System.out.println("ran");
    }
}


