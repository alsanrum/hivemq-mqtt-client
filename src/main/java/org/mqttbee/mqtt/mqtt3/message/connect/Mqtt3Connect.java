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

package org.mqttbee.mqtt.mqtt3.message.connect;

import org.jetbrains.annotations.NotNull;
import org.mqttbee.annotations.DoNotImplement;
import org.mqttbee.internal.mqtt.message.connect.mqtt3.Mqtt3ConnectViewBuilder;
import org.mqttbee.mqtt.mqtt3.message.Mqtt3Message;
import org.mqttbee.mqtt.mqtt3.message.Mqtt3MessageType;
import org.mqttbee.mqtt.mqtt3.message.auth.Mqtt3SimpleAuth;
import org.mqttbee.mqtt.mqtt3.message.publish.Mqtt3Publish;

import java.util.Optional;

/**
 * MQTT 3 Connect message. This message is translated from and to a MQTT 3 CONNECT packet.
 */
@DoNotImplement
public interface Mqtt3Connect extends Mqtt3Message {

    int NO_KEEP_ALIVE = 0;
    int DEFAULT_KEEP_ALIVE = 60;
    boolean DEFAULT_CLEAN_SESSION = true;

    /**
     * Creates a builder for a Connect message.
     *
     * @return the created builder.
     */
    static @NotNull Mqtt3ConnectBuilder builder() {
        return new Mqtt3ConnectViewBuilder.Default();
    }

    /**
     * @return the keep alive in seconds the client wants to use.
     */
    int getKeepAlive();

    /**
     * @return whether the client wants a clean session. If <code>true</code> an existing session is cleared.
     */
    boolean isCleanSession();

    /**
     * @return the optional simple authentication and/or authorization related data of this Connect message.
     */
    @NotNull Optional<Mqtt3SimpleAuth> getSimpleAuth();

    /**
     * @return the optional Will Publish of this Connect message.
     */
    @NotNull Optional<Mqtt3Publish> getWillPublish();

    @Override
    default @NotNull Mqtt3MessageType getType() {
        return Mqtt3MessageType.CONNECT;
    }

    /**
     * Creates a builder for extending this Connect message.
     *
     * @return the created builder.
     */
    @NotNull Mqtt3ConnectBuilder extend();
}
