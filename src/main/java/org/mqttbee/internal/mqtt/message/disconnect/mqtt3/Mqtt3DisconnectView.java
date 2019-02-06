/*
 * Copyright 2018 The MQTT Bee project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.mqttbee.internal.mqtt.message.disconnect.mqtt3;

import org.jetbrains.annotations.NotNull;
import org.mqttbee.annotations.Immutable;
import org.mqttbee.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import org.mqttbee.internal.mqtt.message.disconnect.MqttDisconnect;
import org.mqttbee.mqtt.mqtt3.message.disconnect.Mqtt3Disconnect;
import org.mqttbee.mqtt.mqtt5.message.disconnect.Mqtt5DisconnectReasonCode;

/**
 * @author Silvio Giebl
 */
@Immutable
public class Mqtt3DisconnectView implements Mqtt3Disconnect {

    public static final @NotNull MqttDisconnect DELEGATE =
            new MqttDisconnect(Mqtt5DisconnectReasonCode.NORMAL_DISCONNECTION,
                    MqttDisconnect.SESSION_EXPIRY_INTERVAL_FROM_CONNECT, null, null,
                    MqttUserPropertiesImpl.NO_USER_PROPERTIES);
    public static final @NotNull Mqtt3DisconnectView INSTANCE = new Mqtt3DisconnectView();

    private Mqtt3DisconnectView() {}

    public @NotNull MqttDisconnect getDelegate() {
        return DELEGATE;
    }

    @Override
    public @NotNull String toString() {
        return "MqttDisconnect{}";
    }
}