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
package org.apache.beam.sdk.io.gcp.bigtable.changestreams;

import org.joda.time.Instant;

/** Convert between different Timestamp and Instant classes. */
public class TimestampConverter {
  public static Instant toInstant(com.google.cloud.Timestamp time) {
    return Instant.ofEpochMilli(time.toDate().toInstant().toEpochMilli());
  }

  public static Instant toInstant(com.google.protobuf.Timestamp time) {
    long epochMilli =
        java.time.Instant.ofEpochSecond(time.getSeconds(), time.getNanos()).toEpochMilli();
    return Instant.ofEpochMilli(epochMilli);
  }

  public static com.google.cloud.Timestamp toCloudTimestamp(Instant instant) {
    return com.google.cloud.Timestamp.of(instant.toDate());
  }
}
