/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.huawei.streaming.udfs;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * 字符串裁剪函数测试用例
 *
 */
public class SubStringTest
{

    /**
     * 测试用例
     *
     */
    @Test
    public void test()
    {
        SubString udf = new SubString(null);
        assertTrue(udf.evaluate("abc", 0, 2).equals("ab"));
        assertTrue(udf.evaluate("abc", 1, 2).equals("ab"));
        assertTrue(udf.evaluate("abc", -1, 1).equals("c"));
        assertTrue(udf.evaluate("abc", 2, -1).equals(""));
        assertTrue(udf.evaluate("abc\t", 3, 2).equals("c\t"));
        assertTrue(udf.evaluate("abcd\t", 2, 4).equals("bcd\t"));
        assertTrue(udf.evaluate("abcd   ", 2, 4).equals("bcd "));
        assertTrue(udf.evaluate("abcd", 0, 2).equals("ab"));
    }

    /**
     * 测试用例
     *
     */
    @Test
    public void test2()
    {
        SubString udf = new SubString(null);
        assertTrue(udf.evaluate("abc", 2).equals("bc"));
        assertTrue(udf.evaluate("abc", 1).equals("abc"));
        assertTrue(udf.evaluate("abc", 0).equals("abc"));
        assertTrue(udf.evaluate("abc", -1).equals("c"));
    }

}
