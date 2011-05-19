/*
 * Copyright (c) 2008. All rights reserved.
 */
package ro.isdc.wro.model.resource.processor.impl;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import org.apache.commons.io.IOUtils;

import ro.isdc.wro.model.resource.Resource;
import ro.isdc.wro.model.resource.processor.ResourcePreProcessor;
import ro.isdc.wro.util.WroUtil;


/**
 * CommentStripperProcessor. Removes both type of comments. It uses both: multi line & single line comment strippers.
 *
 * @author Alex Objelean
 * @created Created on Nov 28, 2008
 */
public class CommentStripperProcessor
  implements ResourcePreProcessor {
  /**
   * {@inheritDoc}
   */
  public void process(final Resource resource, final Reader reader, final Writer writer)
    throws IOException {
    try {
      final String content = IOUtils.toString(reader);
      // apply single line comment stripper processor first
      String result = SingleLineCommentStripperProcessor.PATTERN.matcher(content).replaceAll("");
      // apply multi line comment stripper processor after
      result = MultiLineCommentStripperProcessor.PATTERN.matcher(result).replaceAll("");
      result = WroUtil.EMTPY_LINE_PATTERN.matcher(result).replaceAll("");
      writer.write(result);
    } finally {
      reader.close();
      writer.close();
    }
  }
}
