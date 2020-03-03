package com.cimicroservices.deployrunner.core;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {"management.metrics.export.graphite.enabled=true"})
class CiCoreApplicationTest {

  @Test
  void contextLoads() {}
}
