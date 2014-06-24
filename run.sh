USER=$(whoami)
mvn package
java -cp target/customSerialization-1.0-SNAPSHOT.jar:/home/$USER/.m2/repository/com/hazelcast/hazelcast/3.2.3/hazelcast-3.2.3.jar:/home/$USER/.m2/repository/net/sourceforge/findbugs/annotations/1.3.2/annotations-1.3.2.jar:/home/$USER/.m2/repository/com/esotericsoftware/kryo/kryo/2.24.0/kryo-2.24.0.jar:/home/$USER/.m2/repository/com/esotericsoftware/minlog/minlog/1.2/minlog-1.2.jar:/home/$USER/.m2/repository/org/objenesis/objenesis/2.1/objenesis-2.1.jar:/home/$USER/.m2/repository/org/apache/commons/commons-lang3/3.0/commons-lang3-3.0.jar  mainbenchmark.MainBenchmark
