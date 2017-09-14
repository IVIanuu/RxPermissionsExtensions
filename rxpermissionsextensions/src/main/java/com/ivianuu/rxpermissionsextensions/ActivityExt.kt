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

import android.app.Activity
import android.support.annotation.CheckResult
import com.tbruyelle.rxpermissions2.RxPermissions

private val Activity.rxPermissions: RxPermissions by LazyWithReceiver<Activity, RxPermissions> {
    RxPermissions(this)
}

@CheckResult
fun <T> Activity.ensurePermission(vararg permissions: String) = rxPermissions.ensure<T>(*permissions)

@CheckResult
fun <T> Activity.ensureEachPermission(vararg permissions: String) = rxPermissions.ensureEach<T>(*permissions)

@CheckResult
fun Activity.requestPermission(vararg permissions: String) = rxPermissions.request(*permissions)

@CheckResult
fun Activity.requestEachPermission(vararg permissions: String) = rxPermissions.requestEach(*permissions)

@CheckResult
fun Activity.shouldShowRequestPermissionRationale(vararg permissions: String)
        = rxPermissions.shouldShowRequestPermissionRationale(this, *permissions)

fun Activity.isPermissionGranted(permission: String) = rxPermissions.isGranted(permission)

fun Activity.isPermissionRevoked(permission: String) = rxPermissions.isRevoked(permission)