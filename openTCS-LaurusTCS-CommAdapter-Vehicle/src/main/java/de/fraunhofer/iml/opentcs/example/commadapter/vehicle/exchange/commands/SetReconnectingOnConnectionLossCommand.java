/**
 * Copyright (c) Fraunhofer IML
 */
package de.fraunhofer.iml.opentcs.example.commadapter.vehicle.exchange.commands;

import de.fraunhofer.iml.opentcs.example.commadapter.vehicle.LaurusTcsCommAdapter;
import org.opentcs.drivers.vehicle.AdapterCommand;
import org.opentcs.drivers.vehicle.VehicleCommAdapter;

/**
 * A command to set the adapter's reconnect on connection loss flag.
 *
 * @author Martin Grzenia (Fraunhofer IML)
 */
public class SetReconnectingOnConnectionLossCommand
    implements AdapterCommand {

  /**
   * The flag state to set.
   */
  private final boolean reconnect;

  /**
   * Creates a new instance.
   *
   * @param reconnect The flag state to set
   */
  public SetReconnectingOnConnectionLossCommand(boolean reconnect) {
    this.reconnect = reconnect;
  }

  @Override
  public void execute(VehicleCommAdapter adapter) {
    if (!(adapter instanceof LaurusTcsCommAdapter)) {
      return;
    }

    LaurusTcsCommAdapter exampleAdapter = (LaurusTcsCommAdapter) adapter;
    exampleAdapter.getProcessModel().setReconnectingOnConnectionLoss(reconnect);
  }
}
