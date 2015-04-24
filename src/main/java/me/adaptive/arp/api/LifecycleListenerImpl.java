/**
--| ADAPTIVE RUNTIME PLATFORM |----------------------------------------------------------------------------------------

(C) Copyright 2013-2015 Carlos Lozano Diez t/a Adaptive.me <http://adaptive.me>.

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 . Unless required by appli-
-cable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,  WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the  License  for the specific language governing
permissions and limitations under the License.

Original author:

    * Carlos Lozano Diez
            <http://github.com/carloslozano>
            <http://twitter.com/adaptivecoder>
            <mailto:carlos@adaptive.me>

Contributors:

    * Ferran Vila Conesa
             <http://github.com/fnva>
             <http://twitter.com/ferran_vila>
             <mailto:ferran.vila.conesa@gmail.com>

    * See source code files for contributors.

Release:

    * @version v2.2.12

-------------------------------------------| aut inveniam viam aut faciam |--------------------------------------------
*/

package me.adaptive.arp.api;

import com.google.gson.Gson;

/**
   Interface for Managing the Lifecycle listeners
   Auto-generated implementation of ILifecycleListener specification.
*/
public class LifecycleListenerImpl extends BaseListenerImpl implements ILifecycleListener {

     /**
        Constructor with listener id.

        @param id  The id of the listener.
     */
     public LifecycleListenerImpl(long id) {
          super(id);
     }

     /**
        No data received - error condition, not authorized or hardware not available.

        @param error Type of error encountered during reading.
        @since v2.0
     */
     public void onError(ILifecycleListenerError error) {
          AppRegistryBridge.getInstance().getPlatformContextWeb().executeJavaScript("Adaptive.handleLifecycleListenerError( '"+getId()+"', Adaptive.ILifecycleListenerError.toObject(JSON.parse(\"" + AppRegistryBridge.escapeString(getJSONParser().toJson(error)) + "\")) )");
     }

     /**
        Called when lifecycle changes somehow.

        @param lifecycle Lifecycle element
        @since v2.0
     */
     public void onResult(Lifecycle lifecycle) {
          AppRegistryBridge.getInstance().getPlatformContextWeb().executeJavaScript("Adaptive.handleLifecycleListenerResult( '"+getId()+"', Adaptive.Lifecycle.toObject(JSON.parse(\"" + AppRegistryBridge.escapeString(getJSONParser().toJson(lifecycle)) + "\")) )");
     }

     /**
        Data received with warning

        @param lifecycle Lifecycle element
        @param warning   Type of warning encountered during reading.
        @since v2.0
     */
     public void onWarning(Lifecycle lifecycle, ILifecycleListenerWarning warning) {
          AppRegistryBridge.getInstance().getPlatformContextWeb().executeJavaScript("Adaptive.handleLifecycleListenerWarning( '"+getId()+"', Adaptive.Lifecycle.toObject(JSON.parse(\"" + AppRegistryBridge.escapeString(getJSONParser().toJson(lifecycle)) + "\")), Adaptive.ILifecycleListenerWarning.toObject(JSON.parse(\"" + AppRegistryBridge.escapeString(getJSONParser().toJson(warning)) + "\")) )");
     }

}
/**
------------------------------------| Engineered with ♥ in Barcelona, Catalonia |--------------------------------------
*/
