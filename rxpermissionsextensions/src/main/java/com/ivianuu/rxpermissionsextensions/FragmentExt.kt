/*
 * Copyright 2017 Manuel Wrage
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ivianuu.rxpermissionsextensions

import android.app.Fragment
import android.support.annotation.CheckResult
import com.tbruyelle.rxpermissions2.Permission
import io.reactivex.ObservableTransformer

@CheckResult
fun <T> Fragment.ensurePermission(vararg permissions: String) : ObservableTransformer<T, Boolean>
        = activity.ensurePermission<T>(*permissions)

@CheckResult
fun <T> Fragment.ensureEachPermission(vararg permissions: String) : ObservableTransformer<T, Permission>
        = activity.ensureEachPermission<T>(*permissions)

@CheckResult
fun Fragment.requestPermission(vararg permissions: String) = activity.requestPermission(*permissions)

@CheckResult
fun Fragment.requestEachPermission(vararg permissions: String) = activity.requestEachPermission(*permissions)

@CheckResult
fun Fragment.shouldShowRequestPermissionRationale(vararg permissions: String)
        = activity.shouldShowRequestPermissionRationale(*permissions)

fun Fragment.isPermissionGranted(permission: String) = activity.isPermissionGranted(permission)

fun Fragment.isPermissionRevoked(permission: String) = activity.isPermissionRevoked(permission)