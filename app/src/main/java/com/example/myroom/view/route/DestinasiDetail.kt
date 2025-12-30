package com.example.myroom.view.route

import com.example.myroom.R

object DestinasiDetail : DestinasiNavigasi {
    override val route = "detail"
    override val titleRes = R.string.detail_siswa
    const val siswaIdArg = "siswaId"
    val routeWithArgs = "$route/{$siswaIdArg}"
}