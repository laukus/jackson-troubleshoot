import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class JacksonGetTextTest {

    private String getRawFieldValueFromParser(JsonParser parser)
        throws IOException, NoSuchFieldException, IllegalAccessException {

        while ( parser.nextToken() != JsonToken.END_OBJECT) {
            String name = parser.getCurrentName();
            if("_raw".equals(name)) {
                parser.nextToken();

                //this returns only 10000 characters..
                return parser.getText();
            }
        }
        return null;
    }

    @Test
    public void testRaw() throws IOException, NoSuchFieldException, IllegalAccessException {
        String longJson = "{\"preview\":false,\"offset\":0,\"result\":{\"_bkt\":\"sec-something-metadata~61~1F875200"
            + "-B9EB-454B-8B70-7BC52546829C\",\"_cd\":\"61:164862\",\"_indextime\":\"1601022954\","
            + "\"_raw\":\"{\\\"context\\\":\\\"0770fc1f-ff0a-11ea-adf0-00505684e5da\\\","
            + "\\\"digest\\\":[\\\"sha256:02c368717bb92c2d3271b15ac59f48abb139a79541c603bb5b1d1df1f994f1bf\\\"],"
            + "\\\"traceType\\\":\\\"DEPLOYABLE_IMAGE\\\","
            + "\\\"links\\\":[\\\"sha256:72c62b78b79c1367a8040ceb3cf3e357ccb70846eda452fb7d526be5dc9a5a22\\\","
            + "\\\"sha256:28872bdfae70514ca08442b02a0f7bb22abc25c1d09da38b4b7caaa7bb62e805\\\"],"
            + "\\\"deployableImage\\\":{\\\"tags\\\":{\\\"SNAPSHOT-release_RST_559_infomeldinger-20200925"
            + ".083454-16-b1.27.3-wingnut11-1.15.0\\\":\\\"container-registry-internal-snapshot.bbbbbb.aaaaa"
            + ".xx:443/xx_abcabcacbabc_rst/testdatagenerator:SNAPSHOT-release_RST_559_infomeldinger-20200925"
            + ".083454-16-b1.27.3-wingnut11-1.15.0\\\","
            + "\\\"release_RST_559_infomeldinger-SNAPSHOT\\\":\\\"container-registry-internal-snapshot.bbbbbb.aaaaa"
            + ".xx:443/xx_abcabcacbabc_rst/testdatagenerator:release_RST_559_infomeldinger-SNAPSHOT\\\"},"
            + "\\\"isSnapshot\\\":false,\\\"imageName\\\":\\\"xx_abcabcacbabc_rst/testdatagenerator\\\","
            + "\\\"bindeps\\\":[{\\\"name\\\":\\\"Dockerfile\\\",\\\"digest\\\":\\\"1b451ae3a9fbeee7\\\","
            + "\\\"size\\\":790},{\\\"name\\\":\\\"FastInfoset-1.2.15.jar\\\","
            + "\\\"digest\\\":\\\"bb7b7ec0379982b9\\\",\\\"size\\\":311876},{\\\"name\\\":\\\"HdrHistogram-2.1.9"
            + ".jar\\\",\\\"digest\\\":\\\"e4631ce165eb400e\\\",\\\"size\\\":114165},{\\\"name\\\":\\\"LatencyUtils-2"
            + ".0.3.jar\\\",\\\"digest\\\":\\\"769c0b82cb2421c8\\\",\\\"size\\\":29779},"
            + "{\\\"name\\\":\\\"accessors-smart-1.2.jar\\\",\\\"digest\\\":\\\"c592b500269bfde3\\\","
            + "\\\"size\\\":30035},{\\\"name\\\":\\\"activemq-broker-5.15.9.jar\\\","
            + "\\\"digest\\\":\\\"54fb99c6522806fe\\\",\\\"size\\\":1189300},{\\\"name\\\":\\\"activemq-client-5.15.9"
            + ".jar\\\",\\\"digest\\\":\\\"af7c007e4f21aab9\\\",\\\"size\\\":1431933},"
            + "{\\\"name\\\":\\\"activemq-core-5.7.0.jar\\\",\\\"digest\\\":\\\"1e07c5849fbb28ba\\\","
            + "\\\"size\\\":3963881},{\\\"name\\\":\\\"activemq-openwire-legacy-5.15.9.jar\\\","
            + "\\\"digest\\\":\\\"87d1a869402ad00c\\\",\\\"size\\\":685737},{\\\"name\\\":\\\"activemq-protobuf-1.1"
            + ".jar\\\",\\\"digest\\\":\\\"26682eb801f70563\\\",\\\"size\\\":147874},"
            + "{\\\"name\\\":\\\"animal-sniffer-annotations-1.14.jar\\\",\\\"digest\\\":\\\"775b7e22fb10026e\\\","
            + "\\\"size\\\":3482},{\\\"name\\\":\\\"annotations-13.0.jar\\\",\\\"digest\\\":\\\"919f0dfe192fb4e0\\\","
            + "\\\"size\\\":17536},{\\\"name\\\":\\\"apiguardian-api-1.1.0.jar\\\","
            + "\\\"digest\\\":\\\"fc9dff4bb36d627b\\\",\\\"size\\\":2387},{\\\"name\\\":\\\"asm-5.0.4.jar\\\","
            + "\\\"digest\\\":\\\"0da08b8cce7bbf90\\\",\\\"size\\\":53297},"
            + "{\\\"name\\\":\\\"bbbbbb-autentisering-rest-4.1.0.jar\\\",\\\"digest\\\":\\\"82200c005acb2ed0\\\","
            + "\\\"size\\\":82290},{\\\"name\\\":\\\"bbbbbb-header-mdc-filter-2.1.0.jar\\\","
            + "\\\"digest\\\":\\\"97ed1ba3687f200e\\\",\\\"size\\\":6123},"
            + "{\\\"name\\\":\\\"bbbbbb-spring-boot2-starter-2.3.0.jar\\\",\\\"digest\\\":\\\"b49da886e6847a8d\\\","
            + "\\\"size\\\":17322},{\\\"name\\\":\\\"bbbbbb-sts-client-0.7.9.jar\\\","
            + "\\\"digest\\\":\\\"95cc400191a4bae7\\\",\\\"size\\\":48775},{\\\"name\\\":\\\"boks-api-6.2.3.jar\\\","
            + "\\\"digest\\\":\\\"48cd750625484d38\\\",\\\"size\\\":53262},{\\\"name\\\":\\\"byte-buddy-1.9.12"
            + ".jar\\\",\\\"digest\\\":\\\"39050dbbd36862ea\\\",\\\"size\\\":3277212},{\\\"name\\\":\\\"cache-api-1.1"
            + ".0.jar\\\",\\\"digest\\\":\\\"77bdcff7814076df\\\",\\\"size\\\":51266},{\\\"name\\\":\\\"caffeine-2.8"
            + ".0.jar\\\",\\\"digest\\\":\\\"6000774d7f8412ce\\\",\\\"size\\\":879660},"
            + "{\\\"name\\\":\\\"checker-qual-2.10.0.jar\\\",\\\"digest\\\":\\\"5786699a0cb71f9d\\\","
            + "\\\"size\\\":201216},{\\\"name\\\":\\\"classmate-1.4.0.jar\\\","
            + "\\\"digest\\\":\\\"291658ac2ce24762\\\",\\\"size\\\":66540},{\\\"name\\\":\\\"commons-codec-1.11"
            + ".jar\\\",\\\"digest\\\":\\\"3acb4705652e1623\\\",\\\"size\\\":335042},"
            + "{\\\"name\\\":\\\"commons-collections4-4.4.jar\\\",\\\"digest\\\":\\\"62ebe7544cb7164d\\\","
            + "\\\"size\\\":751914},{\\\"name\\\":\\\"commons-compress-1.19.jar\\\","
            + "\\\"digest\\\":\\\"7e65777fb451ddab\\\",\\\"size\\\":615064},{\\\"name\\\":\\\"commons-digester-1.8.1"
            + ".jar\\\",\\\"digest\\\":\\\"3dec9b9c7ea9342d\\\",\\\"size\\\":146108},{\\\"name\\\":\\\"commons-io-2.6"
            + ".jar\\\",\\\"digest\\\":\\\"815893df5f31da2e\\\",\\\"size\\\":214788},{\\\"name\\\":\\\"commons-lang-2"
            + ".2.jar\\\",\\\"digest\\\":\\\"ef6449b62937bbd1\\\",\\\"size\\\":243016},"
            + "{\\\"name\\\":\\\"commons-lang3-3.8.1.jar\\\",\\\"digest\\\":\\\"6505a72a097d9270\\\","
            + "\\\"size\\\":501879},{\\\"name\\\":\\\"commons-logging-1.2.jar\\\","
            + "\\\"digest\\\":\\\"4bfc12adfe4842bf\\\",\\\"size\\\":61829},{\\\"name\\\":\\\"commons-math3-3.6.1"
            + ".jar\\\",\\\"digest\\\":\\\"e4ba98f1d4b3c80e\\\",\\\"size\\\":2213560},{\\\"name\\\":\\\"commons-net-3"
            + ".1.jar\\\",\\\"digest\\\":\\\"2298164a7c248440\\\",\\\"size\\\":273370},"
            + "{\\\"name\\\":\\\"commons-validator-1.6.jar\\\",\\\"digest\\\":\\\"e989d1e87cdd6057\\\","
            + "\\\"size\\\":186077},{\\\"name\\\":\\\"cucumber-core-4.8.0.jar\\\","
            + "\\\"digest\\\":\\\"b5ba16143a22f138\\\",\\\"size\\\":638811},{\\\"name\\\":\\\"cucumber-expressions-7"
            + ".0.2.jar\\\",\\\"digest\\\":\\\"0db0453bbd9f8db8\\\",\\\"size\\\":53617},"
            + "{\\\"name\\\":\\\"cucumber-java-4.8.0.jar\\\",\\\"digest\\\":\\\"29703b668b791ec6\\\","
            + "\\\"size\\\":673795},{\\\"name\\\":\\\"cucumber-spring-4.8.0.jar\\\","
            + "\\\"digest\\\":\\\"e1c4770cc8601774\\\",\\\"size\\\":15626},{\\\"name\\\":\\\"curvesapi-1.06.jar\\\","
            + "\\\"digest\\\":\\\"159dd2e8956459a4\\\",\\\"size\\\":111875},{\\\"name\\\":\\\"datatable-1.1.14"
            + ".jar\\\",\\\"digest\\\":\\\"2bc21164cce1bac2\\\",\\\"size\\\":61854},"
            + "{\\\"name\\\":\\\"datatable-dependencies-1.1.14.jar\\\",\\\"digest\\\":\\\"0fc2df1232d73f6d\\\","
            + "\\\"size\\\":1859791},{\\\"name\\\":\\\"error_prone_annotations-2.0.18.jar\\\","
            + "\\\"digest\\\":\\\"5f65affce1684999\\\",\\\"size\\\":12078},{\\\"name\\\":\\\"fst-2.57.jar\\\","
            + "\\\"digest\\\":\\\"70583ffcab07a0c7\\\",\\\"size\\\":396551},"
            + "{\\\"name\\\":\\\"geronimo-j2ee-management_1.1_spec-1.0.1.jar\\\","
            + "\\\"digest\\\":\\\"5372615b0c04c191\\\",\\\"size\\\":20220},{\\\"name\\\":\\\"geronimo-jms_1.1_spec-1"
            + ".1.1.jar\\\",\\\"digest\\\":\\\"c872b46c601d8dc0\\\",\\\"size\\\":32359},{\\\"name\\\":\\\"gherkin-5.1"
            + ".0.jar\\\",\\\"digest\\\":\\\"3bd9e582275159bb\\\",\\\"size\\\":342077},"
            + "{\\\"name\\\":\\\"gherkin-jvm-deps-1.0.4.jar\\\",\\\"digest\\\":\\\"ab5990bf8596b504\\\","
            + "\\\"size\\\":237452},{\\\"name\\\":\\\"guava-23.0.jar\\\",\\\"digest\\\":\\\"c947004bb13d1818\\\","
            + "\\\"size\\\":2614708},{\\\"name\\\":\\\"hawtbuf-1.11.jar\\\",\\\"digest\\\":\\\"8f0e50ad8bea37b8\\\","
            + "\\\"size\\\":50155},{\\\"name\\\":\\\"hawtdispatch-1.11.jar\\\","
            + "\\\"digest\\\":\\\"01fefb873b304694\\\",\\\"size\\\":108734},"
            + "{\\\"name\\\":\\\"hawtdispatch-transport-1.11.jar\\\",\\\"digest\\\":\\\"f930133932548bba\\\","
            + "\\\"size\\\":105315},{\\\"name\\\":\\\"hibernate-validator-6.0.16.Final.jar\\\","
            + "\\\"digest\\\":\\\"ad9557c558972093\\\",\\\"size\\\":1155778},{\\\"name\\\":\\\"httpclient-4.5.8"
            + ".jar\\\",\\\"digest\\\":\\\"c27c9d6f15435dc2\\\",\\\"size\\\":772386},{\\\"name\\\":\\\"httpcore-4.4"
            + ".11.jar\\\",\\\"digest\\\":\\\"de748cf874e4e193\\\",\\\"size\\\":326874},"
            + "{\\\"name\\\":\\\"istack-commons-runtime-3.0.7.jar\\\",\\\"digest\\\":\\\"c197c86ceec7318b\\\","
            + "\\\"size\\\":25523},{\\\"name\\\":\\\"j2objc-annotations-1.1.jar\\\","
            + "\\\"digest\\\":\\\"ed28ded51a8b1c6b\\\",\\\"size\\\":8782},{\\\"name\\\":\\\"jackson-annotations-2.9.0"
            + ".jar\\\",\\\"digest\\\":\\\"07c10d545325e3a6\\\",\\\"size\\\":66519},{\\\"name\\\":\\\"jackson-core-2"
            + ".9.8.jar\\\",\\\"digest\\\":\\\"0f5a654e4675769c\\\",\\\"size\\\":325619},"
            + "{\\\"name\\\":\\\"jackson-core-asl-1.9.2.jar\\\",\\\"digest\\\":\\\"8493982bba172710\\\","
            + "\\\"size\\\":228286},{\\\"name\\\":\\\"jackson-databind-2.9.8.jar\\\","
            + "\\\"digest\\\":\\\"11283f21cc480aa8\\\",\\\"size\\\":1347236},"
            + "{\\\"name\\\":\\\"jackson-dataformat-yaml-2.9.8.jar\\\",\\\"digest\\\":\\\"a1c807329eb0c759\\\","
            + "\\\"size\\\":41381},{\\\"name\\\":\\\"jackson-datatype-jdk8-2.9.8.jar\\\","
            + "\\\"digest\\\":\\\"bcd02aa9195390e2\\\",\\\"size\\\":33391},"
            + "{\\\"name\\\":\\\"jackson-datatype-jsr310-2.9.8.jar\\\",\\\"digest\\\":\\\"28ad1bced632ba33\\\","
            + "\\\"size\\\":100674},{\\\"name\\\":\\\"jackson-mapper-asl-1.9.2.jar\\\","
            + "\\\"digest\\\":\\\"95400a7922ce7538\\\",\\\"size\\\":765648},"
            + "{\\\"name\\\":\\\"jackson-module-parameter-names-2.9.8.jar\\\","
            + "\\\"digest\\\":\\\"c4eef0e6e20d60fb\\\",\\\"size\\\":8642},{\\\"name\\\":\\\"jasypt-1.9.0.jar\\\","
            + "\\\"digest\\\":\\\"0857a1a55a81641c\\\",\\\"size\\\":125643},{\\\"name\\\":\\\"javassist-3.21.0-GA"
            + ".jar\\\",\\\"digest\\\":\\\"598244f595db5c5f\\\",\\\"size\\\":734815},{\\\"name\\\":\\\"javax"
            + ".activation-api-1.2.0.jar\\\",\\\"digest\\\":\\\"85262acf3ca9816f\\\",\\\"size\\\":56674},"
            + "{\\\"name\\\":\\\"javax.annotation-api-1.3.2.jar\\\",\\\"digest\\\":\\\"934c04d3cfef185a\\\","
            + "\\\"size\\\":26586},{\\\"name\\\":\\\"javax.jms-api-2.0.1.jar\\\","
            + "\\\"digest\\\":\\\"5faaa3864ff6025c\\\",\\\"size\\\":64009},{\\\"name\\\":\\\"javax.json-1.1.4"
            + ".jar\\\",\\\"digest\\\":\\\"943f240a509d3c70\\\",\\\"size\\\":128770},{\\\"name\\\":\\\"javax"
            + ".json-api-1.1.jar\\\",\\\"digest\\\":\\\"e708aaf715872f22\\\",\\\"size\\\":28540},"
            + "{\\\"name\\\":\\\"jaxb-api-2.3.1.jar\\\",\\\"digest\\\":\\\"8531ad5ac454cc2d\\\",\\\"size\\\":128076},"
            + "{\\\"name\\\":\\\"jaxb-runtime-2.3.1.jar\\\",\\\"digest\\\":\\\"dd6dda9da676a54c\\\","
            + "\\\"size\\\":1093432},{\\\"name\\\":\\\"jboss-logging-3.3.2.Final.jar\\\","
            + "\\\"digest\\\":\\\"3789d00e859632e6\\\",\\\"size\\\":66469},{\\\"name\\\":\\\"jcip-annotations-1.0-1"
            + ".jar\\\",\\\"digest\\\":\\\"ef31541dd28ae2ce\\\",\\\"size\\\":4722},{\\\"name\\\":\\\"joda-time-2.10.5"
            + ".jar\\\",\\\"digest\\\":\\\"7f1d89817cd20a32\\\",\\\"size\\\":643043},{\\\"name\\\":\\\"jodd-bean-5.0"
            + ".13.jar\\\",\\\"digest\\\":\\\"4f41d69c8b638a5e\\\",\\\"size\\\":125092},{\\\"name\\\":\\\"jodd-core-5"
            + ".0.13.jar\\\",\\\"digest\\\":\\\"a7ecea06b18bfa5b\\\",\\\"size\\\":403497},"
            + "{\\\"name\\\":\\\"json-smart-2.3.jar\\\",\\\"digest\\\":\\\"007396407491352c\\\",\\\"size\\\":120316},"
            + "{\\\"name\\\":\\\"jsr305-1.3.9.jar\\\",\\\"digest\\\":\\\"40719ea6961c0cb6\\\",\\\"size\\\":33015},"
            + "{\\\"name\\\":\\\"jul-to-slf4j-1.7.26.jar\\\",\\\"digest\\\":\\\"8031352b2bb0a49e\\\","
            + "\\\"size\\\":4589},{\\\"name\\\":\\\"kahadb-5.7.0.jar\\\",\\\"digest\\\":\\\"c45eff4b78ca1f5f\\\","
            + "\\\"size\\\":185083},{\\\"name\\\":\\\"kotlin-compiler-1.2.71.jar\\\","
            + "\\\"digest\\\":\\\"60ce5683b413a564\\\",\\\"size\\\":30848877},"
            + "{\\\"name\\\":\\\"kotlin-compiler-embeddable-1.2.71.jar\\\",\\\"digest\\\":\\\"a79f934bfbc1c7e1\\\","
            + "\\\"size\\\":29106171},{\\\"name\\\":\\\"kotlin-daemon-client-1.2.71.jar\\\","
            + "\\\"digest\\\":\\\"fea0d20d599fdd49\\\",\\\"size\\\":579733},{\\\"name\\\":\\\"kotlin-reflect-1.2.71"
            + ".jar\\\",\\\"digest\\\":\\\"7512db3b3182753b\\\",\\\"size\\\":2620470},"
            + "{\\\"name\\\":\\\"kotlin-script-runtime-1.2.71.jar\\\",\\\"digest\\\":\\\"d5439926359caa89\\\","
            + "\\\"size\\\":42158},{\\\"name\\\":\\\"kotlin-script-util-1.2.71.jar\\\","
            + "\\\"digest\\\":\\\"9154f8619b5b337d\\\",\\\"size\\\":81494},{\\\"name\\\":\\\"kotlin-stdlib-1.2.71"
            + ".jar\\\",\\\"digest\\\":\\\"d9717625bb3c7315\\\",\\\"size\\\":962149},"
            + "{\\\"name\\\":\\\"kotlin-stdlib-common-1.2.71.jar\\\",\\\"digest\\\":\\\"ba18ca1aa0e40eb6\\\","
            + "\\\"size\\\":111800},{\\\"name\\\":\\\"log4j-api-2.11.2.jar\\\","
            + "\\\"digest\\\":\\\"f5e9a2ffca496057\\\",\\\"size\\\":266283},{\\\"name\\\":\\\"log4j-to-slf4j-2.11.2"
            + ".jar\\\",\\\"digest\\\":\\\"6d37bf7b046c0ce2\\\",\\\"size\\\":17522},"
            + "{\\\"name\\\":\\\"logback-classic-1.2.3.jar\\\",\\\"digest\\\":\\\"7c4f3c474fb2c041\\\","
            + "\\\"size\\\":290339},{\\\"name\\\":\\\"logback-core-1.2.3.jar\\\","
            + "\\\"digest\\\":\\\"864344400c3d4d92\\\",\\\"size\\\":471901},{\\\"name\\\":\\\"mapstruct-1.2.0.Final"
            + ".jar\\\",\\\"digest\\\":\\\"8609d6eb044e9f6c\\\",\\\"size\\\":20720},"
            + "{\\\"name\\\":\\\"micrometer-core-1.1.4.jar\\\",\\\"digest\\\":\\\"96eabfe2343a4a46\\\","
            + "\\\"size\\\":424943},{\\\"name\\\":\\\"micrometer-registry-prometheus-1.1.4.jar\\\","
            + "\\\"digest\\\":\\\"d93021c4f8e9efcb\\\",\\\"size\\\":25887},{\\\"name\\\":\\\"mqtt-client-1.3.jar\\\","
            + "\\\"digest\\\":\\\"e3722695b436f4d2\\\",\\\"size\\\":111146},{\\\"name\\\":\\\"netty-buffer-4.1.34"
            + ".Final.jar\\\",\\\"digest\\\":\\\"8afc2027eadc7848\\\",\\\"size\\\":278462},"
            + "{\\\"name\\\":\\\"netty-codec-4.1.34.Final.jar\\\",\\\"digest\\\":\\\"0cb53baf46cc5576\\\","
            + "\\\"size\\\":316916},{\\\"name\\\":\\\"netty-codec-dns-4.1.34.Final.jar\\\","
            + "\\\"digest\\\":\\\"40352df88786faf6\\\",\\\"size\\\":54811},{\\\"name\\\":\\\"netty-common-4.1.34"
            + ".Final.jar\\\",\\\"digest\\\":\\\"2dffa21967d36cae\\\",\\\"size\\\":589281},"
            + "{\\\"name\\\":\\\"netty-handler-4.1.34.Final.jar\\\",\\\"digest\\\":\\\"96169098bebda3d1\\\","
            + "\\\"size\\\":426039},{\\\"name\\\":\\\"netty-resolver-4.1.34.Final.jar\\\","
            + "\\\"digest\\\":\\\"528789e98eef5199\\\",\\\"size\\\":32800},{\\\"name\\\":\\\"netty-resolver-dns-4.1"
            + ".34.Final.jar\\\",\\\"digest\\\":\\\"0ca536138bcc4499\\\",\\\"size\\\":132195},"
            + "{\\\"name\\\":\\\"netty-transport-4.1.34.Final.jar\\\",\\\"digest\\\":\\\"f57be6509efa6766\\\","
            + "\\\"size\\\":465006},{\\\"name\\\":\\\"nimbus-jose-jwt-8.16.jar\\\","
            + "\\\"digest\\\":\\\"9dbd60eb9aec46fb\\\",\\\"size\\\":349545},{\\\"name\\\":\\\"nocommons-0.6.jar\\\","
            + "\\\"digest\\\":\\\"2b2e5581034f844e\\\",\\\"size\\\":87653},{\\\"name\\\":\\\"objenesis-2.6.jar\\\","
            + "\\\"digest\\\":\\\"639033469776fd37\\\",\\\"size\\\":55684},{\\\"name\\\":\\\"poi-4.1.1.jar\\\","
            + "\\\"digest\\\":\\\"c915f1a426213a84\\\",\\\"size\\\":2827712},{\\\"name\\\":\\\"poi-ooxml-4.1.1"
            + ".jar\\\",\\\"digest\\\":\\\"216d8bb4c064c3a1\\\",\\\"size\\\":1859884},"
            + "{\\\"name\\\":\\\"poi-ooxml-schemas-4.1.1.jar\\\",\\\"digest\\\":\\\"7bb506f074a5bffc\\\","
            + "\\\"size\\\":7884238},{\\\"name\\\":\\\"re-retrying-3.0.0.jar\\\","
            + "\\\"digest\\\":\\\"bd3ce1aaafc0f357\\\",\\\"size\\\":32993},{\\\"name\\\":\\\"reactive-streams-1.0.2"
            + ".jar\\\",\\\"digest\\\":\\\"323964c36556eb0e\\\",\\\"size\\\":2097},{\\\"name\\\":\\\"reac\","
            + "\"_serial\":\"0\",\"_si\":[\"splunksrvr-envi-indexer16.aaaaa.xx\",\"sec-something-metadata\"],"
            + "\"_sourcetype\":\"_json\",\"_time\":\"2020-09-25 10:35:53.000 CEST\",\"host\":\"krgt-abcdefg-envi-app02"
            + ".aaaaa.xx\",\"index\":\"sec-something-metadata\",\"linecount\":\"1\","
            + "\"source\":\"/opt/local/applicationnom/logs/application.audit.json\",\"sourcetype\":\"_json\","
            + "\"splunk_server\":\"splunksrvr-envi-indexer16.aaaaa.xx\"}}";



        JsonFactory jsonFactory = new JsonFactory();
        JsonParser parser =  jsonFactory.createParser(longJson);

        String raw = getRawFieldValueFromParser(parser);

        //Would expect the length to be 11470 in this case.
        //NO.. truncated json inside json
        assert (raw.length() == 10000);

    }

    @Test
    public void testRaw2() throws IOException, NoSuchFieldException, IllegalAccessException {
        String longLine = "{\"preview\":false,\"offset\":0,\"result\":{\"_bkt\":\"sec-openshift-metadata~61~1F875200"
            + "-B9EB-454B-8B70-7BC52546829C\",\"_cd\":\"61:164862\",\"_indextime\":\"1601022954\","
            + "\"_raw\":\"characterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacters"
            + "characterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacters"
            + "characterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacters"
            + "characterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacters"
            + "characterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacters"
            + "characterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacters"
            + "characterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacters"
            + "characterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacters"
            + "characterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacters"
            + "characterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacters"
            + "characterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacterscharacters\","
            + "\"_serial\":\"0\",\"_si\":[\"psl0splunk-prod-indexer16.skead.no\",\"sec-openshift-metadata\"],"
            + "\"_sourcetype\":\"_json\",\"_time\":\"2020-09-25 10:35:53.000 CEST\",\"host\":\"psl0appsikk-prod-app02"
            + ".skead.no\",\"index\":\"sec-openshift-metadata\",\"linecount\":\"1\","
            + "\"source\":\"/opt/local/sporingslogger/logs/application.audit.json\",\"sourcetype\":\"_json\","
            + "\"splunk_server\":\"psl0splunk-prod-indexer16.skead.no\"}}";



        JsonFactory jsonFactory = new JsonFactory();
        JsonParser parser =  jsonFactory.createParser(longLine);

        String raw = getRawFieldValueFromParser(parser);

        assert( raw.length() > 10000);

    }
}
