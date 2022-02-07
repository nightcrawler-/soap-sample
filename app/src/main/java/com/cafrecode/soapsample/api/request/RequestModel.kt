/*
 * MIT License
 *
 * Copyright (c) 2022  Frederick Nyawaya
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.cafrecode.soapsample.api.request

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element

data class RequestModel constructor(
    @field:Attribute(name = "xmlns")
    @param:Attribute(name = "xmlns")
    var getRowsAttribute: String = "http://cassavaWebservice.com/",

    @field:Element(name = "StrTable", required = false)
    @param:Element(name = "StrTable", required = false)
    var strTable: String? = null,

    @field:Element(name = "StrReturnType", required = false)
    @param:Element(name = "StrReturnType", required = false)
    var strReturnType: String? = null,

    @field:Element(name = "intREturnedRow", required = false)
    @param:Element(name = "intREturnedRow", required = false)
    var intREturnedRow: Integer? = null,

    @field:Element(name = "strDeviceGUID", required = false)
    @param:Element(name = "strDeviceGUID", required = false)
    var strDeviceGUID: String? = null,

    @field:Element(name = "blnCompression", required = false)
    @param:Element(name = "blnCompression", required = false)
    var blnCompression: Boolean? = null,

    @field:Element(name = "CompressedBuffer", required = false)
    @param:Element(name = "CompressedBuffer", required = false)
    var compressedBuffer: String? = null,

    @field:Element(name = "blnTesting", required = false)
    @param:Element(name = "blnTesting", required = false)
    var blnTesting: Boolean? = null,

    @field:Element(name = "markSynced_table", required = false)
    @param:Element(name = "markSynced_table", required = false)
    var markSyncedTable: String? = null,

    @field:Element(name = "markSynced_Keyvalue", required = false)
    @param:Element(name = "markSynced_Keyvalue", required = false)
    var markSyncedKeyvalue: String? = null
)