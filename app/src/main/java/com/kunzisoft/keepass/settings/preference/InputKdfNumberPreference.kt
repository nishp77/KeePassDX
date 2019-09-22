/*
 * Copyright 2019 Jeremy Jamet / Kunzisoft.
 *     
 * This file is part of KeePass DX.
 *
 *  KeePass DX is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  KeePass DX is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with KeePass DX.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package com.kunzisoft.keepass.settings.preference

import android.content.Context
import android.util.AttributeSet
import com.kunzisoft.keepass.R
import com.kunzisoft.keepass.crypto.keyDerivation.KdfEngine

class InputKdfNumberPreference @JvmOverloads constructor(context: Context,
                                                         attrs: AttributeSet? = null,
                                                         defStyleAttr: Int = R.attr.dialogPreferenceStyle,
                                                         defStyleRes: Int = defStyleAttr)
    : InputTextPreference(context, attrs, defStyleAttr, defStyleRes) {

    override fun setSummary(summary: CharSequence) {
        if (summary == UNKNOWN_VALUE_STRING) {
            isEnabled = false
            super.setSummary("")
        } else {
            isEnabled = true
            super.setSummary(summary)
        }
    }

    companion object {
        const val UNKNOWN_VALUE_STRING = KdfEngine.UNKNOWN_VALUE.toString()
    }
}
