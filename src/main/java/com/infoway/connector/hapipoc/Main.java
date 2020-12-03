package com.infoway.connector.hapipoc;

import com.infoway.connector.hapipoc.util.PocLogging;

/**
 This application uses HAPI Java library to test the following concepts:

 - Loading ConceptMaps and using them to remap codes
 - Parse HL7 v2 messages and handle custom Segments
 - Define custom FHIR resources (e.g. Patient)
 - Initialize FHIR resource and deserialize as JSON (e.g. Observation)
 **/

public class Main
{
    public static void main( String[] args )
    {
        PocLogging.log("=================================================================================");
        PocLogging.log("======= Starting HAPI FHIR test app =============================================");
        PocLogging.log("=================================================================================");

        /*
        Expected arguments:
            If none:  Input messages will be loaded from code.  Output will go to logs and standard output
            If 1 argument: Input file for messages.  Output will go to logs and standard output
            If 2 arguments: input file for messages, followed by file name for the output results/message (e.g. JSON FHIR messages)
         */

        //show args
        PocLogging.log(String.format("Arguments provided: %d", args.length));
        for(String arg: args) {
            PocLogging.log("   arg=" + arg);
        }

        PocLogging.log("Working Directory = " + System.getProperty("user.dir"));

        TestConceptMaps.loadAndTestConceptMappers(args);

        TestHL7Parsing.parseHL7v2Messages(args);

        TestFhirResources.playWithFhir(args);

    }


}
