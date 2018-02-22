package org.mqttbee.mqtt.codec.decoder.mqtt3;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import org.mqttbee.annotations.NotNull;
import org.mqttbee.annotations.Nullable;
import org.mqttbee.mqtt.codec.decoder.MqttMessageDecoder;
import org.mqttbee.mqtt.message.publish.puback.MqttPubAckImpl;
import org.mqttbee.mqtt.message.publish.puback.mqtt3.Mqtt3PubAckView;
import org.mqttbee.mqtt5.Mqtt5ClientConnectionDataImpl;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author Daniel Krüger
 * @author Silvio Giebl
 */
@Singleton
public class Mqtt3PubAckDecoder implements MqttMessageDecoder {

    private static final int FLAGS = 0b0000;
    private static final int REMAINING_LENGTH = 2;

    @Inject
    Mqtt3PubAckDecoder() {
    }

    @Nullable
    @Override
    public MqttPubAckImpl decode(
            final int flags, @NotNull final ByteBuf in,
            @NotNull final Mqtt5ClientConnectionDataImpl clientConnectionData) {

        final Channel channel = clientConnectionData.getChannel();

        if (flags != FLAGS) {
            channel.close(); // TODO
            return null;
        }

        if (in.readableBytes() != REMAINING_LENGTH) {
            channel.close(); // TODO
            return null;
        }

        final int packetIdentifier = in.readUnsignedShort();

        return Mqtt3PubAckView.wrapped(packetIdentifier);
    }

}