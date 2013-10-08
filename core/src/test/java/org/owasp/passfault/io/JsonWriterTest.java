/* ©Copyright 2011 Cameron Morris
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.owasp.passfault.io;

import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Test;
import org.owasp.passfault.MockPasswordResults;
import org.owasp.passfault.PasswordPattern;
import org.owasp.passfault.PathCost;
import org.owasp.passfault.io.JsonWriter;


public class JsonWriterTest {

  @Test
  public void testPatternToJSON() throws IOException {
    MockPasswordResults results = new MockPasswordResults("test");
    results.foundPattern(new PasswordPattern(1, 2, "te", 300, "This is a test pattern", "testPattern", "test"));
    results.foundPattern(new PasswordPattern(3, 2, "st", 350, "This is another test pattern", "testPattern2", "test"));
    PathCost pathCost = results.calculateHighestProbablePatterns();
    JsonWriter writer = new JsonWriter();
    writer.write(new PrintWriter(System.out, true), pathCost);
  }
}
