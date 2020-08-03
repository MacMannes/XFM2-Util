package nl.macmannes.xfm2.util.domain

import nl.macmannes.xfm2.util.domain.external.json.JsonHelper
import nl.macmannes.xfm2.util.domain.external.sysex.SysExHelper
import java.io.File

object FileHelper {
    fun readFile(filePath: String): Program {
        val file = File(filePath)
        if (file.exists()) {
            return when (file.extension) {
                "json" -> JsonHelper.readFile(filePath)
                "syx" -> SysExHelper.readSysExFile(file)
                else -> throw Exception("Could not determine file type of `${file.name}``")
            }
        } else {
            throw Exception("Could not find file `$filePath`")
        }
    }
}