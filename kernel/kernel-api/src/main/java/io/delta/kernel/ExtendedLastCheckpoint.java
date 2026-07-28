/*
 * Copyright (2026) The Delta Lake Project Authors.
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

package io.delta.kernel;

import io.delta.kernel.annotation.Experimental;
import io.delta.kernel.data.Row;
import io.delta.kernel.internal.checkpoints.CheckpointMetaData;
import java.util.Map;
import java.util.Optional;

/**
 * Extended contents of the {@code _last_checkpoint} file used to construct a snapshot.
 *
 * <p>This value is captured only when explicitly requested through {@link
 * SnapshotBuilder#withExtendedLastCheckpoint(boolean)}. Its fields come from the same single read
 * that selected the starting checkpoint for snapshot construction.
 */
@Experimental
public final class ExtendedLastCheckpoint extends CheckpointMetaData {

  /** Internal constructor used by Kernel while constructing a snapshot. */
  public ExtendedLastCheckpoint(CheckpointMetaData metadata) {
    super(
        metadata.version,
        metadata.size,
        metadata.parts,
        metadata.sizeInBytes,
        metadata.numOfAddFiles,
        metadata.v2Checkpoint,
        metadata.checksum,
        metadata.tags);
  }

  public long getVersion() {
    return version;
  }

  public long getSize() {
    return size;
  }

  public Optional<Long> getParts() {
    return parts;
  }

  public Optional<Long> getSizeInBytes() {
    return sizeInBytes;
  }

  public Optional<Long> getNumOfAddFiles() {
    return numOfAddFiles;
  }

  public Optional<Row> getV2Checkpoint() {
    return v2Checkpoint;
  }

  public Optional<String> getChecksum() {
    return checksum;
  }

  public Map<String, String> getTags() {
    return tags;
  }
}
