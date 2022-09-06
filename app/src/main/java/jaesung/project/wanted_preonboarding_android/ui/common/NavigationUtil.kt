package jaesung.project.wanted_preonboarding_android.ui.common

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

object NavigationUtil {

    fun View.navigate(action: Int) {
        Navigation.findNavController(this).navigate(action)
    }

    fun Fragment.navigateWithBundle(action: Int, bundle: Bundle) {
        findNavController().navigate(action, bundle)
    }

    fun Fragment.navigate(action: Int) {
        this.findNavController().navigate(action)
    }

    fun Fragment.navigateUp() {
        findNavController().navigateUp()
    }

    fun Fragment.popBackStack() {
        findNavController().popBackStack()
    }
}